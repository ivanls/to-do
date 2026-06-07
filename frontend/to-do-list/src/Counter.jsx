import React,{ use, useState } from "react"


function Counter(){
    const [count, setCount] = useState(0);

    const incrementCount = () => {
        setCount(count => count + 1);
    }

    const decrementCount = () => {
        setCount(count - 1);    }

    const resetCount = () => {
        setCount(0)
    }

    return(
        <div>
            <p>Count: {count}</p>

            <button onClick={incrementCount}>Increment Age</button>
            <button onClick={decrementCount}>Decrement Age</button>
            <button onClick={resetCount}>Reset Count</button>
        </div>
    );

}

export default Counter