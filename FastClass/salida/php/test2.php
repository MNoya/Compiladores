<?php 
class test2 extends Padre implements Interfaz, Interfaz2 { 
	public $property;
	public $read;
	public $read_write;
	public $read_constructor;

	public __construct($read_constructor) {
		$this->read_constructor = $read_constructor;
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
	public function setRead_constructor($read_constructor){
		$this->read_constructor = $read_constructor;
	}

}
?>
