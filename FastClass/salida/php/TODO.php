<?php 
class TODO { 

	public __construct() {
	}

	class test1 extends Padre implements Interfaz, Interfaz2 { 
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

		class sub_clase1 extends Padre implements Interfaz, Interfaz2 { 
			public $read_write;

			public __construct() {
			}
			public function getRead_write(){
				return $this->read_write;
			}
			public function setRead_write($read_write){
				$this->read_write = $read_write;
			}

			class sub_sub_clase_1 implements Interfaz, Interfaz2 { 
				public $read_only;

				public __construct() {
				}
				public function getRead_only(){
					return $this->read_only;
				}

				class sub_sub_sub_clase1 extends Padre implements Interfaz { 
					public $write_only;

					public __construct() {
					}
					public function setWrite_only($write_only){
						$this->write_only = $write_only;
					}

				}
			}
		}
		class sub_clase2 extends Padre { 
			public $read_write;

			public __construct($read_write) {
				$this->read_write = $read_write;
			}
			public function getRead_write(){
				return $this->read_write;
			}
			public function setRead_write($read_write){
				$this->read_write = $read_write;
			}

		}
	}
	class test2 extends Padre implements Interfaz, Interfaz2 { 
					public $property;
	public $read;
	public $read_write;
	public $read_constructor;

		public __construct($property, $read_constructor) {
			$this->property = $property;
			$this->read_constructor = $read_constructor;
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
		public function setRead_constructor($read_constructor){
			$this->read_constructor = $read_constructor;
		}

	}
	class test3 { 

		public __construct() {
		}

	}
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
}
?>
