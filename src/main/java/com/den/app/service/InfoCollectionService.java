package com.den.app.service;

import java.util.List;

public interface InfoCollectionService<T> {

    List<T> getInfo();
    void showChanges();

}
