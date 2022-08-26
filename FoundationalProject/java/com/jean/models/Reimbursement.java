package com.jean.models;



import java.time.LocalDateTime;


public class Reimbursement {

	private int rId;
	private double amount;
	private LocalDateTime submissionDateTime;
	private LocalDateTime resolutionDateTime;
	private String description;
	private String receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private ReimbursementStatus status;
	private int typeId;
	private ReimbursementType type;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int rId, double amount, LocalDateTime submissionDateTime, LocalDateTime resolutionDateTime,
			String description, String receipt, int authorId, int resolverId, int statusId, ReimbursementStatus status,
			int typeId, ReimbursementType type) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.submissionDateTime = submissionDateTime;
		this.resolutionDateTime = resolutionDateTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
	}

	public Reimbursement(double amount, LocalDateTime submissionDateTime, LocalDateTime resolutionDateTime, String description,
			String receipt, int authorId, int resolverId, int statusId, ReimbursementStatus status, int typeId,
			ReimbursementType type) {
		super();
		this.amount = amount;
		this.submissionDateTime = submissionDateTime;
		this.resolutionDateTime = resolutionDateTime;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmissionDateTime() {
		return submissionDateTime;
	}

	public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
		this.submissionDateTime = submissionDateTime;
	}

	public LocalDateTime getResolutionDateTime() {
		return resolutionDateTime;
	}

	public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
		this.resolutionDateTime = resolutionDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", submissionDateTime=" + submissionDateTime
				+ ", resolutionDateTime=" + resolutionDateTime + ", description=" + description + ", receipt=" + receipt
				+ ", authorId=" + authorId + ", resolverId=" + resolverId + ", statusId=" + statusId + ", status="
				+ status + ", typeId=" + typeId + ", type=" + type + "]";
	}

	

}
