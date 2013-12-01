var i18n_months  = ["Janeiro", "Fevereiro","Março","Abril","Maio","Junho","Julho", "Agosto","Setembro", "Outubro", "Novembro", "Dezembro"];
var i18n_days  = ["Domingo", "Segunda-Feira","Terça-Feira","Quarta-Feira","Quinta-Feira","Sexta-Feira","Sabado"];

//Date Util
Date.prototype.getYearGap = function(){
	var ret = new Date(this.getTime());
	return this.getFullYear() - ret.getFullYear();
};
Date.prototype.getStartOfMonth = function(){
	var ret = new Date(this.getTime());
	ret.setDate(1)
	return ret;
};
Date.prototype.getEndOfMonth = function(){
	var lastDayOfMonth = new Date(this.getFullYear(), this.getMonth()+1, 0);
	return lastDayOfMonth;
}

Date.prototype.getSixMonthAgo= function(){
	var ret = new Date(this.getTime());
	ret.setMonth(ret.getMonth()-6)
	return ret;
};
Date.prototype.getAYearAgo = function(){
	var ret = new Date(this.getTime());
	ret.setFullYear(ret.getFullYear()-1)
	return ret;
};
Date.prototype.getStartOfWeek= function(){
	var d = new Date(this.getTime());
	d.setDate(d.getDate()-d.getDay())
	return d;
};
Date.prototype.getDateBr = function(){
	return window.getDateBr(this);
};
Date.prototype.getMonthBrName = function(){
	return i18n_months[this.getMonth()];
};

Date.prototype.getDateUs = function(){
	var d = new Date(this.getTime());
	month = d.getMonth()+1;
	if(month <10 ){
		month = "0"+month;
	}
	var day = d.getDate();
	if(day <10){
		day = "0"+day;
	}
	var date_str = d.getFullYear()+"-"+month+"-"+day;
	return date_str;
};
Date.prototype.getTextWhen = function(){
	return i18n_days[this.getDay()]+" "+this.getDate()+" de "+i18n_months[this.getMonth()]+" de "+this.getFullYear();
};