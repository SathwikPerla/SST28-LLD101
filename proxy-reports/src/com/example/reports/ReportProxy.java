package com.example.reports;

/*
 * PROXY OBJECT
 *
 * RESPONSIBILITIES:
 * 1. Access Control → check if user is allowed
 * 2. Lazy Loading → create RealReport only when needed
 * 3. Caching → reuse the loaded RealReport
 *
 * Clients interact with this proxy instead of RealReport directly.
 */

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;


    private final AccessControl accessControl = new AccessControl();

    // Cached real report (initially null → lazy loading)
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }


    @Override
    public void display(User user) {

        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED for " + user.getName());
            return;
        }

        // Lazy loading + caching
        if (realReport == null) {
            realReport = new RealReport(reportId, title, classification);
        }

        realReport.display(user);
    }
}