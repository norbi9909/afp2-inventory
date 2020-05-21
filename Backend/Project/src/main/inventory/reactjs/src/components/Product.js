import React, {Component} from 'react';
import {Card, Form, Button, Col} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faSave, faPlusSquare, faUndo} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';
import MyToast from './MyToast';

export default class Product extends Component{

    constructor(props){
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.productChange = this.productChange.bind(this);
        this.submitProduct = this.submitProduct.bind(this);
    }

    initialState={
        productName:'', productDescription:'', productCount:'', productPrice:'', productIsAvailable:''
    }

    resetProduct = () => {
        this.setState(() => this.initialState);
    }

    submitProduct = event => {
        event.preventDefault();

        const product = {
            productName: this.state.productName,
            productDescription: this.state.productDescription,
            productCount: this.state.productCount,
            productPrice: this.state.productPrice,
            productIsAvailable: this.state.productIsAvailable
        };

        axios.post("http://localhost:8081/product/save", product)
            .then(response => {
                if(response.data != null){
                    this.setState({"show":true});
                    setTimeout(() => this.setState({"show":false}), 1500);
                } else {
                    this.setState({"show":false});
                }
            });

        this.setState(this.initialState);
    }

    productChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render(){
        const {productName, productDescription, productCount, productPrice, productIsAvailable} = this.state;

        return(
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast children = {{show:this.state.show, message:"Product saved successfully!", type:"success"}}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>
                    <FontAwesomeIcon icon={faPlusSquare} /> Add New Product
                </Card.Header>
                <Form onReset={this.resetProduct} onSubmit={this.submitProduct} id="productFormId">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridName">
                                <Form.Label >Product Name</Form.Label>
                                <Form.Control required autoComplete="off"
                                    type="text" name="productName"
                                    value={productName} onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Name" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridDescription">
                                <Form.Label>Product Description</Form.Label>
                                <Form.Control required autoComplete="off"
                                    type="text" name="productDescription"
                                    value={productDescription} onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Description" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridCount">
                                <Form.Label>Product Count</Form.Label>
                                <Form.Control required autoComplete="off"
                                    type="number" name="productCount"
                                    value={productCount} onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Count" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Product Price</Form.Label>
                                <Form.Control required autoComplete="off"
                                    type="number" name="productPrice"
                                    value={productPrice} onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Price (Ft)" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridavAilable">
                                <Form.Label>Is it available right now?</Form.Label>
                                <Form.Control required autoComplete="off"
                                    type="text" name="productIsAvailable"
                                    value={productIsAvailable} onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="True or False" />
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                        <Button site="sm" variant="success" type="submit">
                            <FontAwesomeIcon icon={faSave} /> Submit
                        </Button>{' '}
                        <Button site="sm" variant="info" type="reset">
                            <FontAwesomeIcon icon={faUndo} /> Reset
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
            </div>
        );
    }
}