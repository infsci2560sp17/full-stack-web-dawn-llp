# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/).

## [Unreleased]
### Added
- TBD.

## [v1.5] - 2017-04-22
### Fixed
- LoginIT.java
    - Annotated, no confict with Authentication
### Modified
- Navigation Bar
    - Show "Sign Up" or "Hello, user's name" according to login status
- Footer
- MvcConfig.java
    - added signup part
- FullStackWebApplication.java
    - delete some initializing data
- LiAuthenticationProvider.java
    - Add try for exception
- WebSecurityConfig.java
    - Logout and signup access    
### Added
- User registeration
    - signup.html
    - users/add in controller
    - WebConfig.java

## [v1.4.1] - 2017-03-25
### Modified
- README.md
    - Add key features, design pictures and api example
- MvcConfig.java
    - Delete registeries for picupload, PicataResult and actions.
- WebSecurityConfig.java
    - Delete picupload, PicataResult.
- PalettesController.java
    - Add DELETE /palettes/{id}, POST palettes/add, PUT /palettes/like/{id}, PUT /palettes/dislike/{id}
- LipicPalettes.java
    - modify like and dislike method
- PalettesService.java
    - Add LikeReturn function
    - Add DELETE /{id}
    - Add update palette's numLikes and numDislikes method @RequestMapping(value = "/ajax/like/{id}", produces = "application/json")

### Fixed
- match.html
    - Ajax call successfully connected service and repository.
    - Make number of likes and dislikes change visible.
    
## [v1.4] - 2017-03-24
### Added
- LiAuthenticationProvider.java
    - New user authority management strategy to try separate users and admin. Not fully complete yet. It has conflicts with src/test/java/edu/infsci2560/LoginIT.java, debug needed.
- Controllers
    - ActionsController.java (entity related)
    - FileUploadController.java
    - HomeController.java
    - MatchServiceController.java 
    - PalettesController.java (entity related)
    - UserHistoryController.java (entity related)
    - UsersController.java (entity related)
- Models
    - LipicPalettes.java (stored entity)
    - LipicReqActions.java (stored entity)
    - LipicUsers.java (stored entity)
    - LipicUsersPictures.java (stored entity)
    - PictaReqResult.java
    - Tcl_themes.java
    - Tinfo.java
    - Tkuler_themes.java
    - TpictaResp.java
- Coordinator
    - PictaCoordinator.java; temporary object for picture-palette matching info.
    - picture-palette match process models in Models folder are planned to move into this folder.
- Repositories
    - PalettesRepository.java
    - ReqActionsRepository.java
    - UsersPicturesRepository.java
    - UsersRepository.java   
- Services
    - ActionRecordService.java
    - PalettesService.java
    - UsersService.java
- Storage (deal with MultipartFile image storage)
    - FileSystemStorageService.java
    - StorageException.java
    - StorageFileNotFoundException.java
    - StorageProperties.java
    - StorageService.java
- Templates (bootstrap styling)
    - actions.html 
    - history.html
    - match.html (picture-palette match result page; ajax like and dislike connection, need debug)
    - palettes.html
    - shared.html
    - users.html
    
### Modified
- Pom.xml
    - Add thumbnailator, gson, httpcomponents, bootstrap(not work), webjars-locator,jquery dependencies.
- FullStackWebApplication.java
    - Add LipicUsers and LipicPalettes into repositories for initializing test data.
    - Delete previous Database Demo (customers).
- MvcConfig.java
    - Add new registeries: picupload, PicataResult, actions, history, users
- WebSecurityConfig.java
    - Use LiAuthenticationProvider and add antMatchers("/api", "/pictaupload", "/PictaResult", "/match", "/users", "/palettes", "/files", "/files/**)  for easy testing
- PicturesService.java
    - Uses new picture model: LipicPictures, and UsersPicturesRepository to deal with MultipartFile image.
- Home.html
    - Deploy my plan 2 design and get Bootstrap styling 
- login.html
    - Deploy my plan 2 design and get Bootstrap styling 

### Deleted
- pictures.html
    
## [v1.3.1] - 2017-02-16
### Rename
- PictureService -> PicturesService
- PictureController -> PicturesController
- https://obscure-wave-64798.herokuapp.com/ -> https://colorsense.herokuapp.com/

### Modified
- Picture.java
    - Add set and get method for all parameters
    - Capitalize the name of parameter in get/set function name, eg getimgURL() -> getImgURL()
- pictures.html
    - Separate image upload part from addPicForm
    
## [v1.3] - 2017-02-09
### Added based on Teacher's templates
- Model
    - Picture.java
- Controller
    - PictureController.java
- Repository
    - PictureRepository.java
- Service
    - PictureService.java
- templates
    - pictures.html

### Modified
- MvcConfig.java
    - add viewer "pictures"
- home.html
    - direct to "pictures"
    
   
## [v1.2.1] - 2017-01-26
### Modified
- CHANGELOG.md
    - Correct tag url

## [v1.2] - 2017-01-26
### Added
- Answered in README.md
    - What is the proposed name for your Web application?
    - Who is the target audience for your Web application?
    - What problem is it intended to solve for the target audience?
    - How will it meet the minimum project requirements?
    - Why is your proposed Web application unique or creative beyond simply meeting the minimum requirements?
- Added CHANGELOG

## [v1.1] - 2017-01-12
### Added
- Cloned, configured, and compiled the scaffold project.
- Configured Codenvy developer workspace.
- Deployed to Heroku.
- Push to github.


[Unreleased]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.5...HEAD
[v1.5]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.4.1...v1.5
[v1.4.1]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.4...v1.4.1
[v1.4]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.3.1...v1.4
[v1.3.1]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.3...v1.3.1
[v1.3]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.2.1...v1.3
[v1.2.1]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.2...v1.2.1
[v1.2]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/v1.1...v1.2
[v1.1]: https://github.com/infsci2560sp17/full-stack-web-dawn-llp/compare/...v1.1
