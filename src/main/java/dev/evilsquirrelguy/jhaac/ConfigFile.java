package dev.evilsquirrelguy.jhaac;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import dev.evilsquirrelguy.jhaac.Config;
import org.jsoup.nodes.Element;

public class ConfigFile {

  private final Document document;
  private final Config config;


  public ConfigFile(File configFile) throws IOException {
    // overload to read from file
    this(Files.readString(configFile.toPath()));
  }

  public ConfigFile(String config) {
    // read document
    this.document = Jsoup.parse(config);
    // get root config element
    Element main = document.selectFirst("main#config");
    this.config = new Config(main);
  }

  public Config getConfig() {
    return config;
  }

  public ConfigEntry getEntry(String path) {
    String[] pathElements = path.split("\\.");

    ConfigGroup grp = this.config;

    for (int i = 0; i < pathElements.length - 1; i++) {
      grp = config.getGroup(pathElements[i]);
      if (grp == null) return null;
    }
    return grp.getEntry(pathElements[pathElements.length - 1]);
  }

  public String toHtml() {
    return document.outerHtml();
  }



}
