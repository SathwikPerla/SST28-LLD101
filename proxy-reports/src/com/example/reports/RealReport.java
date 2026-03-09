package com.example.reports;

/*
 * REAL SUBJECT in Proxy Pattern
 *
 * RESPONSIBILITY:
 * Performs the expensive operation of loading the report.
 *
 * DESIGN IDEA:
 * The real report should only be created when access is allowed
 * and when the report is actually needed (lazy loading).
 */

public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private String content; // expensive data

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;

        loadFromFile(); // simulate expensive loading
    }

    // Simulate expensive file read
    private void loadFromFile() {
        System.out.println("Loading report from disk: " + reportId);
        content = "Report Content for " + title;
    }

    @Override
    public void display(User user) {
        System.out.println("Displaying report: " + title);
        System.out.println(content);
    }

    public String getClassification() {
        return classification;
    }
}