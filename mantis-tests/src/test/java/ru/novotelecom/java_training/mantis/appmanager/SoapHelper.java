package ru.novotelecom.java_training.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.novotelecom.java_training.mantis.model.Issue;
import ru.novotelecom.java_training.mantis.model.Project;
import ru.novotelecom.java_training.mantis.tests.TestBase;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper extends TestBase {
    private ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }
    public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();

        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream()
                .map((p)->new Project().withId(p.getId().intValue()).wihtName(p.getName())).collect(Collectors.toSet());
    }


    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        String[] categories = mc.mc_project_get_categories("administrator", "root", BigInteger.valueOf(issue.getProject().getId()));
        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()),issue.getProject().getName()));
        issueData.setCategory(categories[0]);
        BigInteger issueId= mc.mc_issue_add("administrator", "root",issueData);
        IssueData createdIssueData = mc.mc_issue_get("administrator", "root", issueId);
        return new Issue().withId(createdIssueData.getId().intValue())
                .withSummary(createdIssueData.getSummary()).withDescription(createdIssueData.getDescription())
                .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                .wihtName(createdIssueData.getProject().getName()));

    }
}
