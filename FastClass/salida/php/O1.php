<?php 
class O1 extends Padre implements Interfaz, Interfaz2 { 
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

	class O2 extends Padre implements Interfaz, Interfaz2 { 
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

		class O3 extends Padre implements Interfaz, Interfaz2 { 
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

			class O4 extends Padre implements Interfaz, Interfaz2 { 
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
	}
}
?>
