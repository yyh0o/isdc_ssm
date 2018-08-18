package isdc.isdcssm.service.Impl;


import isdc.isdcssm.dao.SemesterDAO;
import isdc.isdcssm.model.Semester;
import isdc.isdcssm.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-7-24.
 */
@Service("SemesterService")
@Transactional
public class SemesterServiceImpl implements SemesterService {

    private final SemesterDAO semesterDAO;

    @Autowired
    public SemesterServiceImpl(SemesterDAO semesterDAO) {
        this.semesterDAO = semesterDAO;
    }

    @Override
    public List<Semester> listAll() {
        return semesterDAO.selectAll();
    }

    @Override
    public void addSemester(Semester semester) {
        semesterDAO.insert(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        semesterDAO.updateByPrimaryKey(semester);
    }

    @Override
    public void deleteSemester(Semester semester) {
        semesterDAO.delete(semester);
    }

    @Override
    public Semester findSemesterByDate(Date date) {
        return semesterDAO.selectByDate(1);
    }
}
