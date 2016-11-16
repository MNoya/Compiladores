<?php 
class test7 extends Dad implements Interfaz { 
	public $p;

	public __construct($p) {
		$this->p = $p;
	}
	public function getP(){
		return $this->p;
	}
	public function setP($p){
		$this->p = $p;
	}

}
?>
