<?php 
class O1 extends Padre implements Interfaz, Interfaz2 { 
	public $p;
	public $read;
	public $read_write;
	public $read_constructor;

	public __construct($p, $read, $read_write, $read_constructor) {
		$this->p = $p;
		$this->read = $read;
		$this->read_write = $read_write;
		$this->read_constructor = $read_constructor;
	}
	public function getP(){
		return $this->p;
	}
	public function setP($p){
		$this->p = $p;
	}
	public function setRead($read){
		$this->read = $read;
	}
	public function setRead_write($read_write){
		$this->read_write = $read_write;
	}
	public function getRead_constructor(){
		return $this->read_constructor;
	}

	class O2 extends Padre implements Interfaz, Interfaz2 { 
		public $read_write;

		public __construct($read_write) {
			$this->read_write = $read_write;
		}
		public function setRead_write($read_write){
			$this->read_write = $read_write;
		}

		class O3 extends Padre implements Interfaz, Interfaz2 { 
			public $read_only;

			public __construct($read_only) {
				$this->read_only = $read_only;
			}
			public function setRead_only($read_only){
				$this->read_only = $read_only;
			}

			class O4 extends Padre implements Interfaz, Interfaz2 { 
				public $write_only;

				public __construct($write_only) {
					$this->write_only = $write_only;
				}
				public function getWrite_only(){
					return $this->write_only;
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
}
?>
