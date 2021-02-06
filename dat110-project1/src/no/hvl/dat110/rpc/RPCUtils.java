package no.hvl.dat110.rpc;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()+1];
		byte[] b = new byte[str.length()];
 
		// TODO: marshall RPC identifier and string into byte array
		encoded[0]=rpcid;
		b=str.getBytes();
		
		for (int i = 0; i < b.length; i++) {
			encoded[i+1]=b[i];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		// TODO: unmarshall String contained in data into decoded
		String decoded=new String(data,1,data.length-1);
		

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

	
		// TODO: marshall RPC identifier in case of void type
		byte[] encoded = new byte[1];
		encoded[0] =rpcid;
		
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		// TODO: marshall RPC identifier and string into byte array
		byte[] encoded = new byte[2];
		encoded[0]=rpcid;
		Integer b = new Integer(x);
		encoded[1]=b.byteValue();
		
		
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded ;

		// TODO: unmarshall integer contained in data
		Byte b = new Byte(data[1]);
		decoded = b & 0xFF;

		return decoded;

	}
}
