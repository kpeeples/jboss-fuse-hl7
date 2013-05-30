package com.mycompany.healthcare.service;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.v22.datatype.PN;
import ca.uhn.hl7v2.model.v22.message.ACK;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.util.Terser;

public class PatientLookupService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public Message lookupPatient(Message input) throws HL7Exception {
    
    	Message response = null;
    	try {
    		response = input.generateACK();
    		System.out.println("Enter lookupPatient");
    		System.out.println("Cast message to ADT_A01");
    		System.out.println("Print structure: " + input.printStructure());
    		ADT_A01 adtMsg = (ADT_A01) input;
    		System.out.println("Get MSH");
    		MSH msh = adtMsg.getMSH();
    		// Retrieve some data from the MSH segment
    		System.out.println("Get message type and trigger");
    		String msgType = msh.getMessageType().getMessageType().getValue();
    		String msgTrigger = msh.getMessageType().getTriggerEvent().getValue();
    		System.out.println(msgType + " " + msgTrigger);
    		PN patientName = adtMsg.getPID().getPatientName();
    		String familyName = patientName.getFamilyName().getName();
    		System.out.println("patient name: " + patientName.getFamilyName().getValue());
    		// find patient data based on the patient id and create a HL7 model object with the response
    		// This still depends on the ackMsg decl. being for the same specific version
    		// as the original message.
    		ACK ackMsg = null;
    		try {
    			ackMsg = (ACK) input.generateACK();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    			ackMsg.getMSA().getAcknowledgementCode().setValue("AR");
    			response = (Message) ackMsg;
    		}
    		catch (Exception ex)
    		{
    			ex.printStackTrace();
    		}
    		return response;
    	}


}
