class Person{
	public static $question=array();
	public static think(){
		sleep(5);
		return true;
	}

	public static answer(){
		echo "success";
	}
}

$ret=Person::think();
if($ret){
	Person::answer();
}else{
	echo "answer error";
}