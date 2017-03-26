# LiPic

1. What is the proposed name for your Web application?
    - LiPic
2. Who is the target audience for your Web application?
    - Ordinary people who want to have better color match in daily life(choosing clothes etc) or work(design keynote/ppt etc).
3. What problem is it intended to solve for the target audience?
    - When you go out for an important meeting, do you get the right color tie? When you prepare a PPT or Keynote, do you select a good palette for your topic? 
    People might say color match is so complicate that only fashion designers care. And even designers take months to study a lot palettes to decide their ideal ones.
    - Inspired by the way that professional designers study palettes, I want to present people a service recommending them "good" palette based on their pictures.
    Extract colors of user-upload pictures, compare them with good palette dataset, rate them with similarity of a good palette, show similar palette recommendation.
    - Learning from similar "good" palette, people can adjust their color selection with a little effort and get a big improvement in terms of color match.
4. How will it meet the minimum project requirements?
    - Users need to create their account to use the service.
    - Users upload their pictures to get similar palette recommendation. These records are stored for them.
    - Users can delete past uploads.
    - Use 3rd party API to extract image property.
    - Use 3rd party API to import "good" palette examples.
    - Show recommendation result to users by self-defined functions. 
5. Why is your proposed Web application unique or creative beyond simply meeting the minimum requirements?
     - My site recommends palettes to users according to their original works. First, people get a simple start. 
     No hassles to study good palettes, or fashion magzines, or label the colar values. Just take a picture, upload it and wait for recommendations.
     Second, they get improving suggestion based on their original works. They do not need to change a lot to get a good match.
     
     
## Build status

Travis Build
<br>[![Build Status](https://travis-ci.org/infsci2560sp17/full-stack-web-dawn-llp.svg?branch=master)](https://travis-ci.org/infsci2560sp17/full-stack-web-dawn-llp)

## Changelog

[Changelog](CHANGELOG.md)

## Web Site
<br>[LiPic](https://colorsense.herokuapp.com/)

## Key Features

TODO : Please list key features of your project.

* Key Feature 1 
    + Extract image file dominant colors and show to users.
* Key Feature 2
    + Recommend Kuler palette to users according to palette similarity.
* Key Feature 3
    + User can "like" or "dislike" recommended palette.
* Key Feature 4
    + Show list of all palettes.
* Key Feature 5
    + Show list of personal history. 
* Key Feature 6
    + Show list of users. 

## Project Details

### Draft
Plan 1
<br>![](https://github.com/infsci2560sp17/full-stack-web-dawn-llp/blob/master/plan1.png)

Plan 2
<br>![](https://github.com/infsci2560sp17/full-stack-web-dawn-llp/blob/master/plan2%20.png)


### Landing Page

Invite users to test their pictures 
<br>![](https://github.com/infsci2560sp17/full-stack-web-dawn-llp/blob/master/homepage.png)

### User Input Form

1.Upload picture

![](https://.../image.jpg)

2.Input username and password to login.

## API

PalettesService maps LipicPalettes information, having GET, POST, DELETE and 2 self-defined functions to update like/dislike numbers.

### API Method 1

    GET public/api/palettes/{id}

#### Parameters

- NA

#### Response

A JSON contains information of this palette.

#### Errors

- NA a blank page

#### Example

##### Request

    https://colorsense.herokuapp.com/public/api/palettes/12

##### Body

    tags=cute,puppy ?? what does it mean?


##### JSON Response

```json
{"id":12,"kuler_id":"77179","cl_id":"58617","colors":["D0FA14","E0CD3F","3DD3F6","BC9F86","798BB3"],"numLikes":12,"numDislikes":66,"kuler_rating":"2","cl_rating":"5","author":"mystery","dateCreated":"10/11/2020","userFirst":1842}
```

##### XML Response
- NA

## Technologies Used

TODO : List all technologies used in your project

- [Spring Boot](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications.
- [Thymleaf](http://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
- [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
- [Bootstrap](http://getbootstrap.com/getting-started/) - Bootstrap is a free and open-source front-end web framework for designing websites and web applications. It contains HTML- and CSS-based design templates for typography, forms, buttons, navigation and other interface components, as well as optional JavaScript extensions. 
