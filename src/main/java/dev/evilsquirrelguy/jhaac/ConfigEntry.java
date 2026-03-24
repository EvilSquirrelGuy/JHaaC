package dev.evilsquirrelguy.jhaac;

import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.function.Function;

public class ConfigEntry {

  private final Element element;

  private final Map<String, Object> cache = new HashMap<>();

  public ConfigEntry(Element element) {
    this.element = element;
  }

  public @Nullable String getString() {
    // look at element type and read depending on what it is
    if (element.hasAttr("value")) return element.attr("value");
    return null;
  }

  public int getInt() {
    return (int) cache.computeIfAbsent("int", k ->
      Integer.parseInt(Objects.requireNonNull(getString()))
    );
  }

  public long getLong() {
    return (long) cache.computeIfAbsent("long", k ->
        Long.parseLong(Objects.requireNonNull(getString()))
    );
  }

  public float getFloat() {
    return (float) cache.computeIfAbsent("float", k ->
        Float.parseFloat(Objects.requireNonNull(getString()))
    );
  }

  public double getDouble() {
    return (double) cache.computeIfAbsent("double", k ->
        Double.parseDouble(Objects.requireNonNull(getString()))
    );
  }

  public boolean getBoolean() {
    return (boolean) cache.computeIfAbsent("bool", k ->
        element.hasAttr("checked")
    );
  }

  @SuppressWarnings("unchecked")
  public List<ConfigEntry> getList() {
    // only select can have values
    return (List<ConfigEntry>) cache.computeIfAbsent("list", k -> {
      if (!element.tagName().equals("select")) return new ArrayList<ConfigEntry>(0);

      Elements elements = element.getElementsByTag("option");

      return elements.stream().map(ConfigEntry::new).toList();
    });

  }

}
