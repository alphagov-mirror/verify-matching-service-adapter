package uk.gov.ida.matchingserviceadapter.utils.manifest;

import com.google.common.base.Throwables;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@Singleton
public class ManifestReader {

    public Attributes getManifest() {
        URLClassLoader cl = (URLClassLoader) getClass().getClassLoader();
        Manifest manifest;
        try {
            URL url = cl.findResource("META-INF/MANIFEST.MF");
            manifest = new Manifest(url.openStream());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return manifest.getMainAttributes();
    }
}
