<?php 
class test6 extends Padre { 
	public $property;
	public $read;
	public $read_write;
	public $write_constructor;

	public __construct($property, $write_constructor) {
		$this->property = $property;
		$this->write_constructor = $write_constructor;
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
	public function getRead_write(){
		return $this->read_write;
	}
	public function setRead_write($read_write){
		$this->read_write = $read_write;
	}
	public function setWrite_constructor($write_constructor){
		$this->write_constructor = $write_constructor;
	}

}
?>
