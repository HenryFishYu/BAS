# A simple BAS Calculate


### Introduce
### Attention:You can't get the real result with this but only a reault approaching to the real result.
> This can calculate One dollar n times equation,get the limit or approach anynumber
> 
>accuracy means the distance between (leftX)xl and (rightX)xr (accuracy*step should bigger than 0.05,maybe 0.1 is much more better,or you have to adjustment eta and step,but the largest step is 1)
>
>defaultX means the begin position,because a quadratic equation might have two x with the same y
>
>times means how many times we will calculate(the large times is and the small accuracy is , we will get a result much more approach the real result)
>
> ### The Chinese introduce will be finished later
>
>#####Update 1.2.0:
>
>Using abstract method getY instead,override getY(double x) to decided how to calculate the result
>
>Please watch example BASTest class
>
>Add a new mutation number "mutationalX",the default value is true,set it off if you need some simple calculate like "quadratic equation of one unknown"(it would be faster than true).
>
>#####Update 1.1.0:
>
>Abandon step and eta using sigmoid instead
>