<div id="top"></div>

<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Agrotir/CompassTrack">
    <img src="https://github.com/Agrotir/CompassTrack/raw/master/images/compass.jpg" alt="Logo">
  </a>

<h3 align="center">Compass Track</h3>

  <p align="center">
    A <a href="https://dev.bukkit.org" target="_blank">Bukkit</a> plugin for tracking players.
    <br />
    <br />
    <a href="https://github.com/Agrotir/CompassTrack/issues">Report Bug</a>
    ·
    <a href="https://github.com/Agrotir/CompassTrack/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#stargazers">Stargazers</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

- [Java 17](https://www.oracle.com/java/)
- [Apache Maven](https://maven.apache.org/)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

### Prerequisites

1. `Java Runtime Environment (JRE) 17` or above. Use the following command to check your java version:

   ```sh
   java --version
   ```

   Example output:

   ```sh
   java 17 2021-09-14 LTS
   Java(TM) SE Runtime Environment (build 17+35-LTS2724)
   Java HotSpot(TM) 64-Bit Server VM (build 17+35-LTS2724, mixed mode, sharing)
   ```

2. Download the server jar file from either [CraftBukkit](https://getbukkit.org/download/craftbukkit) or [Spigot](https://getbukkit.org/download/spigot). It is recommended that it is placed in a folder as new files would be generated when running the server.

### Installation

1.  Download the latest release of this plugin [here](https://github.com/Agrotir/CompassTrack/releases).
2.  Run the server file, e.g. `craftbukkit-1.18.2.jar`, file with the following command:
    ```sh
    java -Xmx1024M -Xms1024M -jar craftbukkit-1.18.2.jar nogui
    ```
    Change the following as needed:
    - Xmx (Maximum size, in bytes, of the memory allocation pool)
    - Xms (Initial size, in bytes, of the memory allocation pool)
3.  Open up `eula.txt` and change:

    ```
    eula=false
    ```

    to

    ```
    eula=true
    ```

4.  Drag and drop the downloaded `CompassTrack.jar` into the `plugins` folder.

    ```
    .
    └── my_server/
        ├── world/
        │   └── ...
        ├── world_nether/
        │   └── ...
        ├── world_the_end/
        │   └── ...
        ├── logs/
        │   └── ...
        ├── plugins/
        │   └── CompassTrack.jar  <---  Here
        ├── craftbukkit-1.18.2.jar
        ├── eula.txt
        ├── server.properties
        └── ...
    ```

5.  Rerun the command to start the server:

    ```sh
    java -Xmx1024M -Xms1024M -jar craftbukkit-1.18.2.jar nogui
    ```

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->

## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ROADMAP -->

## Roadmap

- [ ] Working in nether
- [ ] Using NBT tags
- [ ] Code Optimisations
- [ ] Bukkit Permissions
- [ ] Bukkit Configurations

See the [open issues](https://github.com/Agrotir/CompassTrack/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under the GPLv3 License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- lmao jk up to you -->

## Stargazers

<p>"Programmer Dream isn't real. He can't hurt you."</p>

<p>Programmer Dream:</p>

<img src="https://github.com/Agrotir/CompassTrack/raw/master/images/statistics.png" alt="statistics">

Also, according to GitHub’s statistics, only a small percentage of you have starred this project. So if you end up enjoying this plugin, consider giving this project a star. It's free, and you can always change your mind. Enjoy using this plugin.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/Agrotir/CompassTrack/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/Agrotir/CompassTrack/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/Agrotir/CompassTrack/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/Agrotir/CompassTrack/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/Agrotir/CompassTrack/blob/master/LICENSE.txt
[product-screenshot]: images/screenshot.png
