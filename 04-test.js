//var example=require('./example.js');

var example=require('./example');

(1)example.js加载成example对象
(2)example文件夹内的index.js加载成example对象

nodejs 加载文件夹的时候指定要加载的js文件名
       如果不指定默认加载index.js

node_modules文件（1：系统的  2：当前项目）



/*
function example(){
	this.invisibile=function(){

	}

	this.message="hi";
}

var example=new example();
console.log(example.message);*/
