import { useState, useEffect } from 'react';

const useFetch = (url) => {

    const [data, setData] = useState(null);
    const [isPending, setIsPending] = useState(true);
    const [error, setEerror] = useState(null);

    useEffect(() => {
        const abortCont = new AbortController();

        setTimeout(() => {
            fetch(url, { signal: abortCont.signal })
                .then(response => {
                    if (!response.ok) {
                        throw Error('could not fetch the data:(');
                    }
                    return response.json()
                })
                .then(data => {
                    setData(data);
                    setIsPending(false);
                    setEerror(null);
                })
                .catch(error => {
                    if (error.name === 'AbortError') {
                        console.log('Fetch aborted');
                    } else { 
                        setIsPending(false);
                        setEerror(error.message);
                    }
                })
        }, 200)
        
        return () => abortCont.abort();
    }, [url]);


    return { data, isPending, error};
}

export default useFetch;