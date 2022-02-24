package com.binar.grab.service;

import com.binar.grab.model.Train;

import java.util.Map;

public interface TrainService {
    public Map insert(Train contoh);
    public Map getAllSharingTracks();
    public Map getAllAmenitiesContaining(String keyword);
    public Map getAll();
}
