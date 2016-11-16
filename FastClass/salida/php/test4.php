<?php 
class test4 { 
	public $property;
	public $read;
	public $write;
	public $const;

	public __construct($property, $const) {
		$this->property = $property;
		$this->const = $const;
	}
	public function getProperty(){
		return $this->property;
	}
	public function setProperty($property){
		$this->property = $property;
	}
	public function getRead(){
		return $this->read;
	}
	public function setWrite($write){
		$this->write = $write;
	}

}
?>
