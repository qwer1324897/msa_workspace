import React, { useRef } from 'react';

function App() {

    const productIdRef=useRef("");
    const productNameRef=useRef("");

    const order = () => {
        const payload={
            productId:productIdRef.current.value,
            productName:productNameRef.current.value
        }

        fetch("http://localhost:9000/api/orders",{
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            if(!response.ok) throw new Error("주문 오류");
            return response.text();
        })
        .then(data=> {
            console.log("주문 결과: ", data);
        })
        .catch(error => console.log(error));
    };

    return (
    <div style={styles.body}> {/* body 태그 대신 전체를 감싸는 div */}
        <div style={styles.container}>
            <div>주문 요청 창</div> <br />
            <input style={styles.input} placeholder="제품 아이디를 입력하세요" ref={productIdRef}/>
            <input style={styles.input} placeholder="제품명을 입력하세요" ref={productNameRef}/>
            <button style={styles.button} onClick={order}>주문요청</button>
        </div>
    </div>
    );
}


const styles = {
  body: {
    margin: 0,
    display: 'flex',
    justifyContent: 'center', 
    alignItems: 'flex-start',  
    paddingTop: '20vh',
    height: '100vh',
    backgroundColor: '#f9f9f9',
    boxSizing: 'border-box',
  },
  container: {
    display: 'flex',
    flexDirection: 'column', 
    gap: '15px',
    padding: '30px',
    border: '1px solid #ccc',
    borderRadius: '8px',
    backgroundColor: 'white',
    boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
    alignItems: 'center',
  },
  input: {
    padding: '10px',
    width: '250px',
    border: '1px solid #ddd',
    borderRadius: '4px',
  },
  button: {
    padding: '7px',
    width: '100px',
    backgroundColor: '#007bff',
    color: 'white',
    cursor: 'pointer',
    border: 'none',
    borderRadius: '4px', 
  }
};

export default App;