package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
		if(payload.length>127 || payload.length<0) {
			throw new ArrayIndexOutOfBoundsException();  
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		Integer in=payload.length;
		byte index = in.byteValue(); 
		encoded[0]=index;
		
		for(int i =0;i<in;i++) {
			encoded[i+1]=payload[i];
		}
		
		return encoded;
	}


	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		Byte forste = received[0];
		int index = forste.intValue();
		payload = new byte[index];
		
		for (int i = 1; i < index+1; i++) {
			payload[i-1]=received[i];	
		}
	
	}
}
