<?php 
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
				//Codigo fuente original
				```
                some
                source
                code
                ```
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
?>
