package org.opennms.netmgt.config.groups;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;
import org.opennms.core.test.xml.XmlTestNoCastor;

public class GroupsTest extends XmlTestNoCastor<Groupinfo> {

    public GroupsTest(final Groupinfo sampleObject, final Object sampleXml) {
        super(sampleObject, sampleXml, "src/main/resources/xsds/groups.xsd");
    }

    @Parameters
    public static Collection<Object[]> data() throws ParseException {
        final Groupinfo gi = new Groupinfo();
        gi.setHeader(new Header("1.3", "Wednesday, February 6, 2002 10:10:00 AM EST", "dhcp-219.internal.opennms.org"));

        final Group admin = new Group();
        admin.setName("Admin");
        admin.setComments("The administrators");
        admin.addUser("admin");
        gi.addGroup(admin);

        final Group remoting = new Group();
        remoting.setName("Remoting Users");
        remoting.setComments("Users with access for submitting remote poller management data.");
        remoting.addUser("remoting");
        gi.addGroup(remoting);

        return Arrays.asList(new Object[][] {
            {
                gi,
                "<groupinfo  xmlns=\"http://xmlns.opennms.org/xsd/groups\">\n" + 
                "        <header>\n" + 
                "                <rev>1.3</rev>\n" + 
                "                <created>Wednesday, February 6, 2002 10:10:00 AM EST</created>\n" + 
                "                <mstation>dhcp-219.internal.opennms.org</mstation>\n" + 
                "        </header>\n" + 
                "        <groups>\n" + 
                "                <group>\n" + 
                "                        <name>Admin</name>\n" + 
                "                        <comments>The administrators</comments>\n" + 
                "                        <user>admin</user>\n" + 
                "                </group>\n" + 
                "                <group>\n" + 
                "                        <name>Remoting Users</name>\n" + 
                "                        <comments>Users with access for submitting remote poller management data.</comments>\n" + 
                "                        <user>remoting</user>\n" + 
                "                </group>\n" + 
                "        </groups>\n" + 
                "</groupinfo>"
            }
        });
    }
}
