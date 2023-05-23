package com.food.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment{
       
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer paymentid;
	    private String cartholdername;
	    private Long cartno;
	    private String carttype;
	    private String expmonthyear;
	    private String cvv;
	    private Integer amount;
	    
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public Payment(Integer paymentid, String cartholdername, Long cartno, String carttype, String expmonthyear,
				String cvv, Integer amount) {
			super();
			this.paymentid = paymentid;
			this.cartholdername = cartholdername;
			this.cartno = cartno;
			this.carttype = carttype;
			this.expmonthyear = expmonthyear;
			this.cvv = cvv;
			this.amount = amount;
		}



		public Integer getPaymentid() {
			return paymentid;
		}

		public void setPaymentid(Integer paymentid) {
			this.paymentid = paymentid;
		}

		public String getCartholdername() {
			return cartholdername;
		}

		public void setCartholdername(String cartholdername) {
			this.cartholdername = cartholdername;
		}

		

		public Long getCartno() {
			return cartno;
		}



		public void setCartno(Long cartno) {
			this.cartno = cartno;
		}



		public String getCarttype() {
			return carttype;
		}

		public void setCarttype(String carttype) {
			this.carttype = carttype;
		}

		public String getExpmonthyear() {
			return expmonthyear;
		}

		public void setExpmonthyear(String expmonthyear) {
			this.expmonthyear = expmonthyear;
		}

		public String getCvv() {
			return cvv;
		}

		public void setCvv(String cvv) {
			this.cvv = cvv;
		}

		public Integer getAmount() {
			return amount;
		}

		public void setAmount(Integer amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Payment [paymentid=" + paymentid + ", cartholdername=" + cartholdername + ", cartno=" + cartno
					+ ", carttype=" + carttype + ", expmonthyear=" + expmonthyear + ", cvv=" + cvv + ", amount="
					+ amount + "]";
		}



	    
		
	    
	    
}
