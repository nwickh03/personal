package com.lennys.exception;

import com.lennys.util.LennyLinkedListSet;
import com.lennys.util.Node;

public class DuplicateEntryException extends RuntimeException {
    public <T extends Comparable> DuplicateEntryException(String message, Node<T> node, int index) {super(message);

    }
}
