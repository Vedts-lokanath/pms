document.addEventListener('DOMContentLoaded', function () {
  document.addEventListener('input', function (e) {
    const el = e.target;
	 // Allow only alphanumeric (no spaces)
    if (el.classList.contains('alphanum-only')) {
      el.value = el.value.replace(/[^A-Za-z0-9]/g, '');
    }

	 // Allow alphanumeric + space (not at start) 
    if (el.classList.contains('alphanum-no-leading-space')) {
      el.value = el.value.replace(/[^A-Za-z0-9 ]/g, '').replace(/^ +/, '');
    }
	 // Allow alphanumeric + 3 Speceial Characters('-', '/', '\') + space (not at start) 
    if (el.classList.contains('alphanum-symbols-no-leading-space')) {
      el.value = el.value.replace(/[^A-Za-z0-9 \-\/\\]/g, '').replace(/^ +/, '');
    }
    // Allow alphanumeric + 4 Speceial Characters('-', ',', ''', '"') + space (not at start) 
    //comma, single and double quote and hyphen
    if (el.classList.contains('alphanum-quotes-no-leading-space')) {
 	 el.value = el.value.replace(/^\s+/, '')                          
    .replace(/[^A-Za-z0-9,'"’\- ]/g, '');         
	}
	 // Letters only (no spaces allowed)
    if (el.classList.contains('alpha-only')) {
      el.value = el.value.replace(/[^A-Za-z]/g, '');
    }
 	// Letters + space (no leading space)
    if (el.classList.contains('alpha-no-leading-space')) {
      el.value = el.value.replace(/[^A-Za-z ]/g, '').replace(/^ +/, '');
    }
    // Letters + Dot(.) + space (no leading space)
    if (el.classList.contains('alpha-dot-no-leading-space')) {
      el.value = el.value.replace(/[^A-Za-z. ]/g, '').replace(/^ +/, '');
    }
	// Numbers only (no spaces allowed)
    if (el.classList.contains('numeric-only')) {
      el.value = el.value.replace(/[^0-9]/g, '');
    }
 	// Indian mobile number, Only allow if the first digit is 6-9
    if (el.classList.contains('indian-mobile')) {
      let val = el.value.replace(/\D/g, '');
      if (val.length > 0 && !/^[6-9]/.test(val)) {
        val = val.slice(1);
      }
      el.value = val.slice(0, 10);
    }
	// Email-> Only alloow Letters (a-z), Numbers (0-9) and @, ., _, -
    if (el.classList.contains('email-input')) {
      el.value = el.value.replace(/[^a-zA-Z0-9@._-]/g, '');
    }
    // description-> Only allow Letters (a-z), Numbers (0-9) and , ., ,, -, (, ),/,+
    if (el.classList.contains('description-input')) {
      el.value = el.value.replace(/[^a-zA-Z0-9@.,()\-&\/+ '"_]/g, '');
    }

	//referenceNo-> only Letters (a-z), Numbers (0-9) and -,'_'
	if (el.classList.contains('reference_no')) {
	     el.value = el.value.replace(/[^A-Za-z0-9 \-\_]/g, '').replace(/^ +/, '');
	   }

    // Validation for 2 digits after the decimal point
    if (el.classList.contains('decimal-format')) {
       el.value = el.value.replace(/[^0-9.]/g, '')                
				    .replace(/(\..*?)\..*/g, '$1')           
				    .replace(/^(\d+)(\.\d{0,2})?.*$/, '$1$2'); 
    }
    // No HTML tags are allowed.
    if (el.classList.contains('no-html-tag')) {
	  el.value = el.value.replace(/<[^>]*>/g, '');
	  el.value = el.value.replace(/[^a-zA-Z0-9()\-&_ ]/g, '');
	  el.value = el.value.replace(/^\s+/, '');
	}
	//referenceNo-> only Letters (a-z), Numbers (0-9) and -,'_'
	if (el.classList.contains('reference_no')) {
	     el.value = el.value.replace(/[^A-Za-z0-9 \-\_]/g, '').replace(/^ +/, '');
	}

  });
});
