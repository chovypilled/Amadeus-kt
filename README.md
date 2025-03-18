# Note from me, chovypilled
This is a remake/reimagining of <a href=https://github.com/Yink>Yink's</a> Amadeus project written in Kotlin. As it was for him, this is just a side project so I might take longer than expected.   
  
 The reason I didn't fork the original repository directly is because the entire codebase is hideously outdated by now and working on it would prove far too difficult. 
 
 No, I don't intend to plug an LLM into this. LLMs never play characters well and I think using one would be disrespectful to Kurisu.
 
 Credit for the original project goes to <a href=https://github.com/Yink>Yink</a> and I am in no way pretending I came up with the idea of an Amadeus Android app.

<a href=https://github.com/Yink/Amadeus> Link to the original project </a>

Now that all that is out of the way, here are my main intentions:
- Rewrite most of it in Kotlin
- Update for newer Android devices, replacing deprecated features
- Add support for different screen resolutions and landscape orientation

Things I intend to work on later:
- Implement text input
- Improve on assistant features (launching apps, setting alarms/timers)
- Whatever other "upgrades" I come up with down the line.
  
Everything below is the original project's README.md, as it was on 2025/03/14.

# Amadeus
A side project that aims to replicate the Amadeus App shown in Steins;Gate 0 for Android.

I'm creating this mainly for cosplay purposes, thus the design takes priority over actual functionality.
Hit me up on the <a href="https://discord.gg/fTtJ2Ws">Steins;Gate Discord</a>.

To start speech recognition simply touch her once. If you long-click her, she will go on a loop and say random sentences in random intervals. Long-Click again to stop.

# HOW TO INSTALL
<ol>
  <li>Download the <b>amadeus.apk</b> from <a href="https://github.com/Yink/Amadeus/releases">here</a> to your phone (you only need this file).</li>
<li>Make sure to have <b>installation from unknown sources</b> activated in your phone's security settings (<a href="https://www.wikihow.tech/Install-APK-Files-on-Android">How-to<a>)</li>
<li>Click on <b>amadeus.apk</b> on your phone to install it</li>
<li>Choose your preferred settings by clicking on the "Amadeus" logo</li>
</ol>


# Screenshots
<ul>
<li><a href="https://github.com/Yink/Amadeus/blob/master/Screenshots/Callscreen.png?raw=true">Launch View</a></li>
<li><a href="https://github.com/Yink/Amadeus/blob/master/Screenshots/Kurisuscreen.png?raw=true">Main View</a></li>
<li><a href="https://github.com/Yink/Amadeus/blob/master/Screenshots/Settingscreen.png?raw=true">Preference Menu</a></li>
<li><a href="https://github.com/Yink/Amadeus/blob/master/Screenshots/Subscreen.png?raw=true">Main View with English subtitles</a></li>
</ul>

# Recognized commands
Recognition language can be switched between different languages (English, Russian and Japanese are supported right now), but keep in mind that pronouncation may differ and some phrases can't be registered in other languages.
Best experience can be achieved using Japanese.
<ul>
<li>Hello, Ohayou, Konnichiwa, Konbanwa</li>
<li>Christina</li>
<li>Nullpo</li>
<li>@channel, Kurigohan, Kamehameha</li>
<li>Salieri, Maho, Hiyajo</li>
<li>Time machine, SERN, Time travel</li>
<li>Memory, Amadeus, Science</li>
<li>Nice body, Hot, Sexy, Boobies</li>
<li>Robotics;Notes, antimatter</li>
</ul>

# Settings
Here is a short list of available options:
<ul>
<li>Show subtitles - Shows subtitles according to selected app language.</li>
<li>Show XP-Icon - Show XP-Icon in notification bar (see in-game or app screenshots, app restart required)</li>
<li>Recognition language - Switches recognition language. Currently available languages: English, Japanese, Russian, German, French</li>
<li>Application language - Switches application language. Doesn't affect recognition language. Currently available languages: English, Russian, Spanish, Portuguese, Italian, French, German and Chinese (Traditional and Simplified).</li>
<li>Alarm setup - Opens dialog window with alarm feature. Triggers Amadeus call on alarm.</li>
</ul>

# Credits
<ul>
  <li><a href="https://github.com/RIP95">Emojikage</a> for various improvements and advice, Russian translation</li>
  <li><a href="https://github.com/8BitAsian/">8-Bit☆Asian</a> for Zero and S;G Voice Lines and the Website</li>
  <li><a href="https://twitter.com/SG_EPK_X29">EPK</a> for Phenogram Voice Lines</li>
  <li><a href="https://twitter.com/DavixxaYT">Davixxa</a> for Assets</li>
  <li>But He's a Guy and Deadeye for finding the hidden animation in 0</li>
  <li>MARIORUI11 for the Portuguese (Portugal) translation</li>
  <li><a href="https://twitter.com/TehVict">TehVict</a> for the Portuguese (Brazil) translation</li>
  <li><a href="https://twitter.com/gioghurt">Gioghurt</a> for the Spanish translation</li>
  <li><a href="https://twitter.com/DelusionParadox">Ice</a> for a revision of the Spanish translation</li>
  <li><a href="https://twitter.com/AlternisDim96">Alternis Dim96</a> for the Italian translation</li>
  <li>Woute and Okami Amaterasu for the French translation</li>
  <li>History-exe for the Chinese (Simplified) translation</li>
  <li>jaidTw and ekrekeler for the Chinese (Traditional) translation</li>
  <li>Mk-Chan and alexsh for refactoring</li>
  <li><a href="https://twitter.com/rintarokabe">Tiffylenia</a> for the German translation</li>
  <!--<li><a href="https://twitter.com/Chaos_World_300">Rigs</a> for the Japanese subtitles</li>-->
</ul>
