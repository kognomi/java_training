package ru.novotelecom.java_training.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.novotelecom.java_training.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main (String[] args) throws IOException {

        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);

        if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }


}

    private List<ContactData> generateContacts(int count) {

        List <ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("firstname %s",i)).withMidname(String.format("midname %s",i)).
                    withLastname(String.format("lastname %s",i)).withAddress(String.format("address %s",i)).
                    withFirstHomePhone(String.format("111%s",i)).withMobilePhone(String.format("222%s",i)).
                    withWorkPhone(String.format("333%s",i)).withFirstEmail(String.format("%s11@test.tt",i)).
                    withSecondEmail(String.format("%s22@test.tt",i)).withThirdEmail(String.format("%s33@test.tt",i)).
                    withSecondHomePhone(String.format("444%s",i)).withGroup("test1").withPhoto(new File("src/test/resources/grass.png")));
        }
        return contacts;
    }


    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

}
