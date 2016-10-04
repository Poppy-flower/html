CommonJS(
	1:可以把文件加载成模块
	2:提供了module.exports  exports 解决了public private
	)
nodejs才能处理后端

nodejs  异步调用  事件驱动  

//原生JS(封装)*
//Object.prototype  产生一个{}
//Function.prototype 产生是function(){}
//console.log(Function.prototype.isPrototypeOf(Object));
Function =new Object();  //Function --  Object.prototype
Function.prototype=new Object();
console.log(Object.prototype.isPrototypeOf(Function));
console.log(Object.prototype.isPrototypeOf(Function.prototype));


var aa=function(){}

function aa(){

}
/*
console.log(Object instanceof Function);
console.log(Function instanceof Object);

var a=new Array();
console.log(Array instanceof Object);
console.log(a instanceof Object);

console.log(a instanceof Function);
console.log(a instanceof Array);


function test(){

}

var b=new test();
console.log(typeof(b.prototype));   //undefined
console.log(typeof(test.prototype));  //object
console.log(b instanceof test);*/

/*
var http=require('http');

console.log(http.Server);


object---class 
function ---class
function object
new function = object

object 是 function的实例化
function 是 object的实例化
array string math function  ----object*/

/*
function aa(){
	var a=9;   
	this.b=8;
}

var aa=new aa();
alert(aa.a);*/


/*
class aa{
	private $a;
	public $b;
	public function __construct(){
		parent::__construct();
		$this->a=9;
	}
}*/