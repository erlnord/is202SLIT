# is202SLIT

OBS: Prosjektet ligger i mappen som heter 202-slit. Sql-filen som ligger under slitclient/resources/sql må kjøres for at prosjektet skal fungere (slit-construction).

Dette prosjektet er gjort av 6 elever ved Universitetet i Agder, høsten 2015. Prosjektet gitt ut på å lage en bedre måte å levere inn moduler/prosjekter til fagene IS-109 og 110, samt samle informasjon på en bedre måte. 

Prosjektet er gjennomført ved bruk av Java, Beans, MySQL og ikke minst stackoverflow.com. 

Repository ble ikke opprettet før mot slutten av oktober grunnet startvansker med git. Før denne tid hadde hovedsakelig Erlend og Lars Martin jobbet med prosjektet, og den første commiten er prototype v1. Etter dette er det komplett repo-history, selv om denne ikke gir det fullstendige bildet. Mange commits er veldig små eller testcommits, og noen ganger har vi jobbet sammen på skolen men kun pushet fra en maskin. Commits holder seg heller ikke til et brukernavn, da git interpreterer hver forskjellige maskin vi bruker som en ny bruker. Likevel gir repoen et bilde på hvilke to studenter som har utmerket seg i arbeidsmengde (91 av 117 commits i skrivende stund er gjort av Erlend og Lars Martin). Dette innebærer ikke bare commits, men timesvis med feilsøking og prøving, som etterhvert har resultert i videre arbeid. Til tross for noe skjev arbeidsfordeling vil vi si at samarbeidet innad i gruppen har fungert. 

Kjente bugs 1.12.15:
- Innboks fungerer ikke. Dette er på grunn av manglende SSL-sertifikat.
- Man kan ikke velge hvilken innlevering man vil laste ned.
- Innstillinger-siden mangler funksjonalitet. 
- Timeplan-siden mangler funksjonalitet. 
- Sikkerheten er en vits, da hvem som helst kan lage seg en bruker og logge inn. 
- Noen av de ferdige sql-entryene mangler enkelte values. 
- Menylinjen øverst mangler til en viss grad funksjonalitet, da noen av elementene ikke gjør noe. 
- topMenu/ButtonMenu skalerer ikke når man endrer størrelse på skjermen. Dette fordi de er ImageIcons. 
- "Se elevers progresjon" er uten funksjonalitet.
- Opplasting er begrenset til rundt 2mb. 
