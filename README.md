Dokumentation RateYourOutfit

Die Webapplikation RateYourOutfit wurde für das Projekt in Webbasierten Datenbanken von Mathis Kaspar-Müller, Michele Muto und Thomas Ballauer erstellt. RateYourOutfit stellt eine Plattform dar, auf der Outfits hochgeladen, diese bewertet und kommentiert werden können. Die folgenden Absätze erläutern die Installationsanleitung sowie eine kurze Beschreibung der einzelnen Funktionen. 

Verwendete Software:
Die App nutzt Maven als Build-Werkzeug und zur Paketverwaltung. Auf diese Weise
werden die für Jakarta EE notwendigen APIs, darüber hinaus aber keine weiteren
Abhängigkeiten, in das Projekt eingebunden
Genaue Installations-Anleitungen:
https://www.wpvs.de/software/#10

[NetBeans:](https://netbeans.apache.org/) Integrierte Entwicklungsumgebung für Java und andere Sprachen

[Maven:](https://maven.apache.org/) Build-Werkzeug und Verwaltung von Abhängigkeiten

[Git:](https://git-scm.com/") Versionsverwaltung zur gemeinsamen Arbeit am Quellcode

[TomEE:](Version liegt in ZIP bei) Applikationsserver zum lokalen Testen der Anwendung 

[Derby:](Version liegt in ZIP bei) In Java implementierte SQL-Datenbank zum Testen der Anwendung

[Commons-IO] Falls das Paket nicht vorhanden ist, bei den Dependencies einfügen. Ermöglicht das Konvertieren in byte[] bei der Speicherung von Bildern.
          Anleitung: (Wie auf Bild1 auf „Add Dependency“, dann wie auf Bild 2 Felder ausfüllen)

Weitere Informationen: 
-	Die Webanwendung ist auf den Browser FireFox optimiert. Bei der Nutzung anderer Browser kann es zu Darstellungsänderungen kommen. Weiterhin ist die Anwendung nicht nach dem Responsive Webdesign erstellt worden. 
Funktionen im kurzen Überblick:
Benutzerverwaltung
-	Der Nutzer kann sich registrieren, anmelden und abmelden.
-	Innerhalb einer halben Stunde läuft die Session ab und der Nutzer muss sich erneut mit seinen Daten anmelden.
-	Über Logout kann sich der Nutzer abmelden und gelangt an die Anmelde-Seite
Bilder hochladen
-	Der Nutzer kann aus seinem Verzeichnis ein Bild auswählen. Dieses wird dann auf der Upload-Seite angezeigt. 
-	Das Bild muss vor dem endgültigen Hochladen mit einer Beschreibung versehen werden.
-	Durch das Betätigen des Bestätigungsbuttons, wird der Eintrag auf die Plattform hochgeladen. 
Bilder bewerten
-	Jeder Nutzer von RateYourOutit kann die hochgeladenen Outfits bewerten. Dies geschieht über fünf Sterne, die angeklickt werden können. Die Bewertung wird anschließlich durch den Durchschnitt aller Bewertungen dargestellt.
Bilder kommentieren
-	Jeder Nutzer von RateYourOutit kann die hochgeladenen Outfits kommentieren mithilfe des Kommentarfeldes. 

