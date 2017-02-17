# ColorSense

1. What is the proposed name for your Web application?
    - ColorSense
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
    - Probably use 3rd party API to extract image property.
    - Probably use 3rd party API to import "good" palette examples.
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
<br>[ColorSense](https://colorsense.herokuapp.com/)

## Key Features

TODO : Please list key features of your project.

* Key Feature 1 
* Key Feature 2
* Key Feature N

## Project Details

### Landing Page

TODO : please provide a description of your landing page inluding a screen shot ![](https://.../image.JPG)

### User Input Form

TODO : please provide a description of at least 1 user input form including a screen shot ![](https://.../image.jpg)

## API

TODO : please provide a description of at least 1 API including a sample of request data and response data in both XML and JSON format.

### API Method 1

    POST photos/:id/tags

#### Parameters

- **id** _(required)_ — The Photo ID to add tags for.
- **tags** _(required)_ — Comma separated tags.

#### Response

A JSON or XMLobject containing the PhotoID and list of tags accepted.

#### Errors

All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.

- **404 Not Found** — The photo was not found.

#### Example

##### Request

    POST /v1/photos/123456/tags

##### Body

    tags=cute,puppy


##### JSON Response

```json
{
    "photoId": 123456,
    "tags": ["cute", "puppy"]
}
```

##### XML Response

```xml
<?xml version="1.0" encoding="UTF-8"?>
<PhotoTags>
    <photoId>123456</PhotoId>
        <tags>
            <tag>cute</tag>
            <tag>puppy</tag>
        </tags>
</PhotoTags>
```

## Technologies Used

TODO : List all technologies used in your project

- [Spring Boot](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications.
- [Thymleaf](http://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
- [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
