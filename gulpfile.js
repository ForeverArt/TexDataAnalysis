var gulp = require('gulp'),
	$ = require('gulp-load-plugins')();

var paths = {
    js: "./js/*.js",
    css: "./css/*.css"
};

gulp.task("minifyjs", function(){
	return gulp.src(paths.js)
			.pipe($.uglify())
			.pipe(gulp.dest("build/js"));
});