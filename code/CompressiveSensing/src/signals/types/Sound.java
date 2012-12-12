package signals.types;

import matrix.MatrixHelper;

import org.apache.mahout.math.Matrix;

import signals.processing.Decoder;
import signals.processing.Encoder;

public class Sound implements SignalProcessing{
	
	private Matrix signalMatrix;
	
	public Sound(Matrix soundMatrix){
		this.signalMatrix = soundMatrix;
	}
	
	public Matrix getMatrix(){
		return this.signalMatrix;
	}

	@Override
	public void encode() {
		Encoder.encode(this);
	}

	@Override
	public void decode() {
		Decoder.decode(this);
	}
	
	@Override
	public void printMatrix() {
		
		MatrixHelper.printMatrix(signalMatrix);
	}
	
	@Override
	//wrapper around Mahout's matrix multiplication function
	public void multiplyMatrix(Matrix y) {
		
		signalMatrix = signalMatrix.times(y);
	}

}
