/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;





/**
 *
 * @author Erlend
 */
public abstract class MainViewMaster {
    
    // Lager en JFrame som vi kan plassere alle elementene i
    JFrame frame = new JFrame();
    
    // Lager tre JPanels som blir brukt til Ã¥ plassere innhold
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel container = new JPanel();
    
    // Lager en menylinje
    JMenuBar menuBar = new JMenuBar();
    
    // Lager "Fil"-delen av menyen og alt som hÃ¸rer til
    JMenu fileMenu = new JMenu("Fil");
    JMenu openFile = new JMenu("Ã…pne");
    JMenuItem fromLocal = new JMenuItem("Lokalt lagret");
    JMenuItem fromCloud = new JMenuItem("Fra sky");
    JMenuItem saveFile = new JMenuItem("Lagre");
    JMenuItem saveAsFile = new JMenuItem("Lagre Som");
    JMenuItem exitApplication = new JMenuItem("Avslutt applikasjonen");
    
    // Lager "Kontakt"-delen av menyen og alt som hÃ¸rer til
    JMenu contactMenu = new JMenu("Kontakt");
    
    // Lager "Hjelp"-delen av menyen og alt som hÃ¸rer til
    JMenu helpMenu = new JMenu("Hjelp");
    
    // Lager hovedknappene, som blir brukt til Ã¥ manÃ¸vrere seg rundt 
    // i systemet. Bruker bilder som ikoner.
    // Initialiserer infoBtn
    ImageIcon infoImg = new ImageIcon(getClass().getResource("/images/info.jpg"));
    JButton infoBtn = new JButton(infoImg);
    
    // Initialiserer bookingBtn
    ImageIcon bookingImg = new ImageIcon(getClass().getResource("/images/booking.jpg"));
    JButton bookingBtn = new JButton(bookingImg);
    
    // Initialiserer moduleBtn
    ImageIcon moduleImg = new ImageIcon(getClass().getResource("/images/module.jpg"));
    JButton moduleBtn = new JButton(moduleImg);
    
    // Initialiserer mailBtn
    ImageIcon mailImg = new ImageIcon(getClass().getResource("/images/mail.jpg"));
    JButton mailBtn = new JButton(mailImg);
    
    // Initialiserer settingsBtn
    ImageIcon settingsImg = new ImageIcon(getClass().getResource("/images/settings.jpg"));
    JButton settingsBtn = new JButton(settingsImg);
    
    // Lager tekstfeltet der lÃ¦rerene kan legge ut nyheter
    JTextArea infoTxt = new JTextArea();
    JScrollPane infoScroll = new JScrollPane(infoTxt);
    
    // Initialiserer kalender
    UtilDateModel model = new UtilDateModel();
    //model.setDate(20,04,2014);
    // Need this...
    Properties p = new Properties();
       // p.put("text.today", "Today");
       // p.put("text.month", "Month");
       // p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    // Don't know about the formatter, but there it is...
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
 

    
    /**
     * Konstruktor for klassen MainViewMaster
     */
    public MainViewMaster() {
        //Legger til alle elementene i JFrame
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
        //frame.setLayout(new GridLayout(5, 5, 10, 10));
        
        // Legger til fil-menyen i menylinja, og legger til menyelementer
        menuBar.add(fileMenu);
        fileMenu.add(openFile);
        openFile.add(fromLocal);
        openFile.add(fromCloud);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exitApplication);
        
        // Legger til kontakt-menyen i menylinja, og legger til elementer
        menuBar.add(contactMenu);
        
        // Legger til hjelp-menyen i menylinja, og legger til elementer
        menuBar.add(helpMenu);

        
        // Initialiserer top JPanel
        topPanel.setLayout(new GridLayout(1, 5, 10, 10));
        
        // Initialiserer infoBtn
        infoBtn.setBorderPainted(false); // Slipper Ã¥ se linjene til knappen
        infoBtn.setFocusPainted(false); // Slipper Ã¥ se knappen i bakgrunnen
        infoBtn.setContentAreaFilled(false);
        infoBtn.setSize(1, 1);
        infoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(infoBtn);
        
        // Initialiserer bookingBtn
        bookingBtn.setBorderPainted(false);
        bookingBtn.setFocusPainted(false);
        bookingBtn.setContentAreaFilled(false);
        bookingBtn.setSize(1, 1);
        topPanel.add(bookingBtn);
        
        // Initialiserer moduleBtn
        moduleBtn.setBorderPainted(false);
        moduleBtn.setFocusPainted(false);
        moduleBtn.setContentAreaFilled(false);
        moduleBtn.setSize(1, 1);
        topPanel.add(moduleBtn);
        
        // Initialiserer mailBtn
        mailBtn.setBorderPainted(false);
        mailBtn.setFocusPainted(false);
        mailBtn.setContentAreaFilled(false);
        mailBtn.setSize(1, 1);
        topPanel.add(mailBtn);
        
        // Initialiserer settingsBtn
        settingsBtn.setBorderPainted(false);
        settingsBtn.setFocusPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setSize(1, 1);
        topPanel.add(settingsBtn);
        
        
        // Legger til en container for left og rightpanel
        frame.getContentPane().add(container, BorderLayout.CENTER);
        container.setLayout(new GridLayout(1,2));
        container.add(leftPanel);
        container.add(rightPanel);
        
        
        // Legger til topPanel i JFrame
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        
        
        // Initialiserer left JPanel
        leftPanel.setLayout(new BorderLayout()); // Borderlayout for å få textarea til å bruke fullsize
        //leftPanel.setLayout(new GridLayout(4, 3, 10, 10));
        infoTxt.setWrapStyleWord(true); // Linjer pÃ¥ ord istedenfor bokstaver
        infoTxt.setLineWrap(true); // NÃ¥ scroller vi bare horisontalt
        infoTxt.setText("Chapter One\n" 
                + "A Stop on the Salt Route\n" +
"1000 B.C.\n" +
"As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit.\n" +
"Soon Lara spotted other landmarks—an outcropping of limestone beside the path that had a silhouette like a man’s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight.\n" +
"Lara had been back and forth along the river path many times in her short life. Her people had not created the path—it had always been there, like the river—but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara’s people were salt traders, and their livelihood took them on a continual journey.\n" +
"At the mouth of the river, the little group of half a dozen intermingled families gathered salt from the great salt beds beside the sea. They groomed and sifted the salt and loaded it into handcarts. When the carts were full, most of the group would stay behind, taking shelter amid rocks and simple lean-tos, while a band of fifteen or so of the heartier members set out on the path that ran alongside the river.\n" +
"With their precious cargo of salt, the travelers crossed the coastal lowlands and traveled toward the mountains. But Lara’s people never reached the mountaintops; they traveled only as far as the foothills. Many people lived in the forests and grassy meadows of the foothills, gathered in small villages. In return for salt, these people would give Lara’s people dried meat, animal skins, cloth spun from wool, clay pots, needles and scraping tools carved from bone, and little toys made of wood.\n" +
"Their bartering done, Lara and her people would travel back down the river path to the sea. The cycle would begin again.\n" +
"It had always been like this. Lara knew no other life. She traveled back and forth, up and down the river path. No single place was home. She liked the seaside, where there was always fish to eat, and the gentle lapping of the waves lulled her to sleep at night. She was less fond of the foothills, where the path grew steep, the nights could be cold, and views of great distances made her dizzy. She felt uneasy in the villages, and was often shy around strangers. The path itself was where she felt most at home. She loved the smell of the river on a hot day, and the croaking of frogs at night. Vines grew amid the lush foliage along the river, with berries that were good to eat. Even on the hottest day, sundown brought a cool breeze off the water, which sighed and sang amid the reeds and tall grasses.\n" +
"Of all the places along the path, the area they were approaching, with the island in the river, was Lara’s favorite.\n" +
"The terrain along this stretch of the river was mostly flat, but in the immediate vicinity of the island, the land on the sunrise side was like a rumpled cloth, with hills and ridges and valleys. Among Lara’s people, there was a wooden baby’s crib, suitable for strapping to a cart, that had been passed down for generations. The island was shaped like that crib, longer than it was wide and pointed at the upriver end, where the flow had eroded both banks. The island was like a crib, and the group of hills on the sunrise side of the river were like old women mantled in heavy cloaks gathered to have a look at the baby in the crib—that was how Lara’s father had once described the lay of the land.\n" +
"Larth spoke like that all the time, conjuring images of giants and monsters in the landscape. He could perceive the spirits, called numina, that dwelled in rocks and trees. Sometimes he could speak to them and hear what they had to say. The river was his oldest friend and told him where the fishing would be best. From whispers in the wind he could foretell the next day’s weather. Because of such skills, Larth was the leader of the group.\n" +
"“We’re close to the island, aren’t we, Papa?” said Lara.\n" +
"“How did you know?”\n" +
"“The hills. First we start to see the hills, off to the right. The hills grow bigger. And just before we come to the island, we can see the silhouette of that fig tree up there, along the crest of that hill.”\n" +
"“Good girl!” said Larth, proud of his daughter’s memory and powers of observation. He was a strong, handsome man with flecks of gray in his black beard. His wife had borne several children, but all had died very young except Lara, the last, whom his wife had died bearing. Lara was very precious to him. Like her mother, she had golden hair. Now that she had reached the age of childbearing, Lara was beginning to display the fullness of a woman’s hips and breasts. It was Larth’s greatest wish that he might live to see his own grandchildren. Not every man lived that long, but Larth was hopeful. He had been healthy all his life, partly, he believed, because he had always been careful to show respect to the numina he encountered on his journeys.\n" +
"Respecting the numina was important. The numen of the river could suck a man under and drown him. The numen of a tree could trip a man with its roots, or drop a rotten branch on his head. Rocks could give way underfoot, chuckling with amusement at their own treachery. Even the sky, with a roar of fury, sometimes sent down fingers of fire that could roast a man like a rabbit on a spit, or worse, leave him alive but robbed of his senses. Larth had heard that the earth itself could open and swallow a man; though he had never actually seen such a thing, he nevertheless performed a ritual each morning, asking the earth’s permission before he went striding across it.\n" +
"“There’s something so special about this place,” said Lara, gazing at the sparkling river to her left and then at the rocky, tree-spotted hills ahead and to her right. “How was it made? Who made it?”\n" +
"Larth frowned. The question made no sense to him. A place was never made, it simply was. Small features might change over time. Uprooted by a storm, a tree might fall into the river. A boulder might decide to tumble down the hillside. The numina that animated all things went about reshaping the landscape from day to day, but the essential things never changed, and had always existed: the river, the hills, the sky, the sun, the sea, the salt beds at the mouth of the river.\n" +
"He was trying to think of some way to express these thoughts to Lara, when a deer, drinking at the river, was startled by their approach. The deer bolted up the brushy bank and onto the path. Instead of running to safety, the creature stood and stared at them. As clearly as if the animal had whispered aloud, Larth heard the words “Eat me.” The deer was offering herself.\n" +
"Larth turned to shout an order, but the most skilled hunter of the group, a youth called Po, was already in motion. Po ran forward, raised the sharpened stick he always carried and hurled it whistling through the air between Larth and Lara.\n" +
"A heartbeat later, the spear struck the deer’s breast with such force that the creature was knocked to the ground. Unable to rise, she thrashed her neck and flailed her long, slender legs. Po ran past Larth and Lara. When he reached the deer, he pulled the spear free and stabbed the creature again. The deer released a stifled noise, like a gasp, and stopped moving.\n" +
"There was a cheer from the group. Instead of yet another dinner of fish from the river, tonight there would be venison.\n" +
"The distance from the riverbank to the island was not great, but at this time of year—early summer—the river was too high to wade across. Lara’s people had long ago made simple rafts of branches lashed together with leather thongs, which they left on the riverbanks, repairing and replacing them as needed. When they last passed this way, there had been three rafts, all in good condition, left on the east bank. Two of the rafts were still there, but one was missing.\n" +
"“I see it! There—pulled up on the bank of the island, almost hidden among those leaves,” said Po, whose eyes were sharp. “Someone must have used it to cross over.”\n" +
"“Perhaps they’re still on the island,” said Larth. He did not begrudge others the use of the rafts, and the island was large enough to share. Nonetheless, the situation required caution. He cupped his hands to his mouth and gave a shout. It was not long before a man appeared on the bank of the island. The man waved.\n" +
"“Do we know him?” said Larth, squinting.\n" +
"“I don’t think so,” said Po. “He’s young—my age or younger, I’d say. He looks strong.”\n" +
"“Very strong!” said Lara. Even from this distance, the young stranger’s brawniness was impressive. He wore a short tunic without sleeves, and Lara had never seen such arms on a man.\n" +
"Po, who was small and wiry, looked at Lara sidelong and frowned. “I’m not sure I like the look of this stranger.”\n" +
"“Why not?” said Lara. “He’s smiling at us.”\n" +
"In fact, the young man was smiling at Lara, and Lara alone.\n" +
"His name was Tarketios. Much more than that, Larth could not tell, for the stranger spoke a language which Larth did not recognize, in which each word seemed as long and convoluted as the man’s name. Understanding the deer had been easier than understanding the strange noises uttered by this man and his two companions! Even so, they seemed friendly, and the three of them presented no threat to the more numerous salt traders.\n" +
"Tarketios and his two older companions were skilled metalworkers from a region some two hundred miles to the north, where the hills were rich with iron, copper, and lead. They had been on a trading journey to the south and were returning home. Just as the river path carried Larth’s people from the seashore to the hills, so another path, perpendicular to the river, traversed the long coastal plain. Because the island provided an easy place to ford the river, it was here that the two paths intersected. On this occasion, the salt traders and the metal traders happened to arrive at the island on the same day. Now they met for the first time.\n" +
"The two groups made separate camps at opposite ends of the island. As a gesture of friendship, speaking with his hands, Larth invited Tarketios and the others to share the venison that night. As the hosts and their guests feasted around the roasting fire, Tarketios tried to explain something of his craft. Firelight glittered in Lara’s eyes as she watched Tarketios point at the flames and mime the act of hammering. Firelight danced across the flexing muscles of his arms and shoulders. When he smiled at her, his grin was like a boast. She had never seen teeth so white and so perfect.\n" +
"Po saw the looks the two exchanged and frowned. Lara’s father saw the same looks and smiled.\n" +
"The meal was over. The metal traders, after many gestures of gratitude for the venison, withdrew to their camp at the far side of the island. Before he disappeared into the shadows, Tarketios looked over his shoulder and gave Lara a parting grin.\n" +
"While the others settled down to sleep, Larth stayed awake a while longer, as was his habit. He liked to watch the fire. Like all other things, fire possessed a numen that sometimes communicated with him, showing him visions. As the last of the embers faded into darkness, Larth fell asleep.\n" +
"Larth blinked. The flames, which had dwindled to almost nothing, suddenly shot up again. Hot air rushed over his face. His eyes were seared by white flames brighter than the sun.\n" +
"Amid the dazzling brightness, he perceived a thing that levitated above the flames. It was a masculine member, disembodied but nonetheless rampant and upright. It bore wings, like a bird, and hovered in midair. Though it seemed to be made of flesh, it was impervious to the flames.\n" +
"Larth had seen the winged phallus before, always in such circumstances, when he stared at a fire and entered a dream state. He had even given it a name, or more precisely, the thing had planted its name in his mind: Fascinus.\n" +
"Fascinus was not like the numina that animated trees, stones, or rivers. Those numina existed without names. Each was bound to the object in which it resided, and there was little to differentiate one from another. When such numina spoke, they could not always be trusted. Sometimes they were friendly, but at other times they were mischievous or even hostile.\n" +
"Fascinus was different. It was unique. It existed in and of itself, without beginning or end. Clearly, from its form, it had something to do with life and the origin of life, yet it seemed to come from a place beyond this world, slipping for a few moments through a breach opened by the heat of the dancing flames. An appearance by Fascinus was always significant. The winged phallus never appeared without giving Larth an answer to a dilemma that had been troubling him, or planting an important new thought in his mind. The guidance given to him by Fascinus had never led Larth astray.\n" +
"Elsewhere, in distant lands—Greece, Israel, Egypt—men and women worshiped gods and goddesses. Those people made images of their gods, told stories about them, and worshiped them in temples. Larth had never met such people. He had never even heard of the lands where they lived, and he had never encountered or conceived of a god. The very concept of a deity such as those other men worshiped was unknown to Larth, but the closest thing to a god in his imagination and experience was Fascinus.\n" +
"With a start, he blinked again.\n" +
"The flames had died. In place of intolerable brightness there was only the darkness of a warm summer night lit by the faintest sliver of a moon. The air on his face was no longer hot but fresh and cool.\n" +
"Fascinus had vanished—but not without planting a thought in Larth’s mind. He hurried to the leafy bower beside the river where Lara liked to sleep, thinking to himself, It must be made so, because Fascinus says it must!\n" +
"He knelt beside her, but there was no need to wake her. She was already awake.\n" +
"“Papa? What is it?”\n" +
"“Go to him!”\n" +
"She did not need to ask for an explanation. It was what she had been yearning to do, lying restless and eager in the dark.\n" +
"“Are you sure, Papa?”\n" +
"“Fascinus . . . ,” He did not finish the thought, but she understood. She had never seen Fascinus, but he had told her about it. Many times in the past, Fascinus had given guidance to her father. Now, once again, Fascinus had made its will known.\n" +
"The darkness did not deter her. She knew every twist and turn of every path on the little island. When she came to the metal trader’s camp, she found Tarketios lying in a leafy nook secluded from the others; she recognized him by his brawny silhouette. He was awake and waiting, just as she had been lying awake, waiting, when her father came to her.\n" +
"At her approach, Tarketios rose onto his elbows. He spoke her name in a whisper. There was a quiver of something like desperation in his voice; his neediness made her smile. She sighed and lowered herself beside him. By the faint moonlight, she saw that he wore an amulet of some sort, suspended from a strap of leather around his neck. Nestled amid the hair on his chest, the bit of shapeless metal seemed to capture and concentrate the faint moonlight, casting back a radiance brighter than the moon itself.\n" +
"His arms—the arms she had so admired earlier—reached out and closed around her in a surprisingly gentle embrace. His body was as warm and naked as her own, but much bigger and much harder. She wondered if Fascinus was with them in the darkness, for she seemed to feel the beating of wings between their legs as she was entered by the thing that gave origin to life.\n" +
"Copyright © 2007 by Steven Saylor. All rights reserved..");
        infoTxt.setMargin( new Insets(15,15,15,15)); // teksten går ikke helt til kantene
        leftPanel.add(infoScroll, BorderLayout.CENTER); // legger scrollpanen med textarea inni til leftPanel
        leftPanel.setBackground(Color.white);

        
        rightPanel.setBackground(Color.white);
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        rightPanel.add(datePicker);
        
        /**
         * Legger til en actionListener som avslutter applikasjonen
         * dersom man trykker pÃ¥ "avslutt" i menyen.
         * SpÃ¸r ogsÃ¥ brukeren om han/hun er sikker pÃ¥ at applikasjonen skal
         * avsluttes.
         */
        exitApplication.addActionListener(new ActionListener() {
            String message = "Where were you when application was kill?";
            String title = "Avslutt applikasjon";
            @Override
            public void actionPerformed(ActionEvent e) {
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Application is kill RIP.");
                        System.exit(0);
                    }
            }
        }); 
        
        // Lager en actionListener pÃ¥ infoBtn for Ã¥ teste at ting funker
        infoBtn.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Du trykte på en knapp.");
            }
        });
        

  
    }
}

    
    

