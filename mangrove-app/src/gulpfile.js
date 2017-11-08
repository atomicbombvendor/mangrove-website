var gulp = require("gulp"),
    webserver = require("gulp-webserver");
   gulp.task(
              "webserver",function()
                {
                  gulp.src("../")
                  .pipe
                     (webserver
                       ({
                          open:"http://localhost/index.html",
                          port:8080
                       })
                     );
                 });

gulp.task("default",["webserver"],function(){

      console.log("gulp is doing");
});