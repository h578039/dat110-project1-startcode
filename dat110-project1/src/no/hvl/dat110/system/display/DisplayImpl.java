package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	public byte[] invoke(byte[] request) {

		// TODO:
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done in the SensorImpl for the read method

		String message = RPCUtils.unmarshallString(request);

		byte rpcid = request[0];
		
		write(message);

		byte[] reply = RPCUtils.marshallVoid(rpcid);

		return reply;
	}
}
