<?php 
class test5 { 
	public $readwrite;
	public $writeconst;
	public $readcont;
	public $leescrcom;

	public __construct($writeconst, $readcont, $leescrcom) {
		$this->writeconst = $writeconst;
		$this->readcont = $readcont;
		$this->leescrcom = $leescrcom;
	}
	public function getReadwrite(){
		return $this->readwrite;
	}
	public function setReadwrite($readwrite){
		$this->readwrite = $readwrite;
	}
	public function setWriteconst($writeconst){
		$this->writeconst = $writeconst;
	}
	public function getReadcont(){
		return $this->readcont;
	}
	public function getLeescrcom(){
		return $this->leescrcom;
	}
	public function setLeescrcom($leescrcom){
		$this->leescrcom = $leescrcom;
	}

}
?>
