package com.lennys.service;

import com.lennys.dao.JDBCOfferDAO;
import com.lennys.dao.JDBCPaymentDAO;
import com.lennys.dao.JDBCCarDAO;
import com.lennys.dao.Dao;
import com.lennys.exception.DBException;
import com.lennys.model.things.Car;
import com.lennys.model.things.Offer;
import com.lennys.model.things.Payment;
import com.lennys.util.LennyLinkedTreeSet;

public class LotService {
    private static LotService instance;

    private JDBCCarDAO cars;
    private JDBCOfferDAO offers;
    private JDBCPaymentDAO payments;

    public static LotService getInstance(){
        if(null == instance)
            instance = new LotService(new JDBCCarDAO(),new JDBCOfferDAO(),new JDBCPaymentDAO());

        return instance;
    }

    private LotService(JDBCCarDAO cd,JDBCOfferDAO od, JDBCPaymentDAO pd){ cars = cd; offers = od; payments = pd;}

    public boolean exists(Integer vin) {
        return findCarByVin(vin) != null;
    }

    private Car findCarByVin(Integer vin) {
        try {
            return cars.read(vin);
        }catch(DBException e){
            e.printStackTrace();
        }
        return null;
    }
    public void addCarToLot(Car car){
        try {
            cars.create(car);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
    public void removeCarFromLot(Integer id){
        try {
            cars.delete(id);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public LennyLinkedTreeSet<Car> viewMainLot() {
        try {
            return cars.getLotByOwner("lenny");
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void makeOffer(Offer offer) {

        try {
            offers.create(offer);
        } catch (DBException e) {
            e.printStackTrace();
        }


    }

    public LennyLinkedTreeSet<Offer> viewOffers(Car car) {

        try {
            return offers.getByVin(car.getVin());
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void acceptOffer(Offer o) {
        try {
            offers.accept(o);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public void rejectOffer(Offer answer) {
        try {
            offers.reject(answer);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public LennyLinkedTreeSet<Car> viewUserLot(String username) {
        try {
           return cars.getLotByOwner(username);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Payment getPayment(Integer pid) {
        try {
           return payments.read(pid);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LennyLinkedTreeSet<Car> viewOffLot() {
        try {
            return cars.getCarsNotOwned();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
