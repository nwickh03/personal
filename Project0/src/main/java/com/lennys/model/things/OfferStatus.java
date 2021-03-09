package com.lennys.model.things;

public enum OfferStatus {
    PENDING,
    ACCEPTED,
    REJECTED;

    @Override
    public String toString() {
        switch (this) {
            case PENDING: return "Pending";

            case ACCEPTED: return "ACCEPTED";

            case REJECTED: return "Rejected";

            default: return "";
        }
    }
}
