package server;

import java.io.FileInputStream;
import java.util.Properties;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

/**
 * サーバー
 */
public class AppServer {
  public static void main(final String[] args) throws Exception {
    final Properties properties = new Properties();
    properties.load(new FileInputStream("server.properties"));
    final int port = Integer.parseInt(properties.getProperty("port"));
    final String contextPath = properties.getProperty("context_path");
    final String baseDirectoryPath = properties.getProperty("base_directory");
    final Configuration[] configurations = {
        new AnnotationConfiguration(), new WebInfConfiguration(), new WebXmlConfiguration(), new MetaInfConfiguration(), new FragmentConfiguration(), new EnvConfiguration(), new PlusConfiguration(), new JettyWebXmlConfiguration()
    };
    final WebAppContext context = new WebAppContext();
    context.setContextPath(contextPath);
    context.setResourceBase(baseDirectoryPath);
    context.setConfigurations(configurations);
    final Server server = new Server(port);
    server.setHandler(context);
    server.start();
    server.join();
  }
}
