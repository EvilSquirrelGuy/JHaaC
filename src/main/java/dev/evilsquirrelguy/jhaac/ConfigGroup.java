package dev.evilsquirrelguy.jhaac;

import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

public class ConfigGroup {

  protected final Element element;

  private final Map<String, Object> cache = new HashMap<String, Object>();

  public ConfigGroup(Element element) {
    this.element = element;
  }

  public ConfigGroup getGroup(String id) {
    return (ConfigGroup) cache.computeIfAbsent(id, k -> {
      // parse the element
      Element section = element.selectFirst("section#" + id);
      // return element or null
      return section == null ? null : new ConfigGroup(section);
    });
  }

  public ConfigEntry getEntry(String name) {

    return (ConfigEntry) cache.computeIfAbsent(name, k -> {
      // parse the element
      Element entry = element.selectFirst("[name=" + name + "]");
      // return element or null
      return entry == null ? null : new ConfigEntry(entry);
    });
  }

  public ConfigEntry getEntryAtPath(String path) {
    String[] pathElements = path.split("\\.");

    ConfigGroup grp = this;

    for (int i = 0; i < pathElements.length - 1; i++) {
      grp = getGroup(pathElements[i]);
      if (grp == null) return null;
    }
    return grp.getEntry(pathElements[pathElements.length - 1]);
  }

}
