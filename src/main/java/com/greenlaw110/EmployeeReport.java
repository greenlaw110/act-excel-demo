package com.greenlaw110;

import act.apidoc.SampleData;
import act.cli.ReportProgress;
import act.controller.annotation.UrlContext;
import act.job.Every;
import act.util.Async;
import act.util.ProgressGauge;
import act.view.excel.ExcelDirectRender;
import org.osgl.mvc.annotation.GetAction;

import javax.inject.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@UrlContext("report/employee")
public class EmployeeReport {

    private static AtomicInteger counter = new AtomicInteger();

    @Every("10m")
    public void generateReportRegularly() {
        List<Employee> employees = SampleData.generateList(Employee.class, 100);
        File dir = new File("reports");
        dir.mkdir();
        File excelFile = new File(dir, "employees-" + counter.getAndIncrement() + ".xlsx");
        ExcelDirectRender.generateExcelFile(employees, excelFile);
    }

    @Async
    @ReportProgress
    @GetAction("async")
    public List<Employee> generateReportAsynchronously(ProgressGauge gauge) {
        // simulate report generating process
        List<Employee> list = new ArrayList<>();
        int numberOfEmployees = 10000;
        gauge.updateMaxHint(numberOfEmployees);
        for (int i = 0; i < numberOfEmployees; ++i) {
            list.add(SampleData.generate(Employee.class));
            gauge.step();
        }
        return list;
    }

}
