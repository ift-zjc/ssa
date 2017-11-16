package com.ift.services;

import com.ift.domain.TimeLine;
import com.ift.domain.repository.TimeLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLineService {
    @Autowired
    private TimeLineRepository timeLineRepository;

    public TimeLine saveTimeLine (TimeLine timeLine) { return timeLineRepository.save(timeLine); }

    public List<TimeLine> listTimeLine() { return timeLineRepository.findAll(); }
}
