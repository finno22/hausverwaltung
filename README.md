# Hausverwaltung

Ein kleines Programm zum Verwalten von Wohnungen, Nutzung über das Terminal:

- mit *javac HausverwaltungClient.java* komplieren
- *touch [Dateiname].txt*, um eine Datei zum Speichern der Daten zu erstellen

verschiedene Commands:
-*java HausverwaltungClient [Dateiname].txt list* : listet alle gespeicherten Wohnungen und ihre Daten auf
- *java HausverwaltungClient [Dateiname].txt add EW Id Zimmeranzahl Baujahr PLZ Straße Hausnummer Top Betriebskosten/m², Rücklage/m²*: erstellt eine neue Eigentumswohnung mit den angegebenen Daten
- *java HausverwaltungClient [Dateiname].txt add MW Id Zimmeranzahl Baujahr PLZ Straße Hausnummer Top Miete/m², Mieteranzahl*: erstellt eine neue Mietwohnung mit den angegebenen Daten
- *java HausverwaltungClient [Dateiname].txt delete [Id]*: löscht die Wohnung mit der angegebenen Id
- *java HausverwaltungClient [Dateiname].txt oldest*: gibt die älteste/n Wohnung/en aus
- *java HausverwaltungClient [Dateiname].txt meancosts*: gibt den Durchschnittspreis von allen Wohnungen aus
- *java HausverwaltungClient [Dateiname].txt count*: gibt die Anzahl aller Wohnungen aus

