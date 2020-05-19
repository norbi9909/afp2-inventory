import React, {Component} from 'react';
import {Card, Form, Button, Col} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faSave, faPlusSquare} from '@fortawesome/free-solid-svg-icons'

export default class Product extends Component{

    constructor(props){
        super(props);
        this.state = {name:'', description:'', count:'', price:'', productPhotoURL:'', available:''};
        this.productChange = this.productChange.bind(this);
        this.submitProduct = this.submitProduct.bind(this);
    }

    submitProduct(event){
        alert('Name: '+this.state.name+' Description: '+this.state.description+' Count: '+this.state.count+' Price: '+this.state.price+' Product Photo Url: '+this.state.productPhotoURL+' Is it available?: '+this.state.available);
        event.preventDefault();
    }

    productChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render(){
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faPlusSquare} /> Add New Product</Card.Header>
                <Form onSubmit={this.submitProduct} id="productFormId">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridName">
                                <Form.Label >Product Name</Form.Label>
                                <Form.Control required
                                    type="text" name="name"
                                    value={this.state.name}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Name" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridDescription">
                                <Form.Label>Product Description</Form.Label>
                                <Form.Control required
                                    type="text" name="description"
                                    value={this.state.description}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Description" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridCount">
                                <Form.Label>Product Count</Form.Label>
                                <Form.Control required
                                    type="text" name="count"
                                    value={this.state.count}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Count" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridPrice">
                                <Form.Label>Product Price</Form.Label>
                                <Form.Control required
                                    type="text" name="price"
                                    value={this.state.price}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Price" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridProductPhotoURL">
                                <Form.Label>Product Photo URL</Form.Label>
                                <Form.Control required
                                    type="text" name="productPhotoURL"
                                    value={this.state.productPhotoURL}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter Product Photo URL" />
                            </Form.Group>
                            <Form.Group as={Col} controlId="formGridavAilable">
                                <Form.Label>Is it available right now?</Form.Label>
                                <Form.Control required
                                    type="text" name="available"
                                    value={this.state.available}
                                    onChange={this.productChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Yes or No" />
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                        <Button site="sm" variant="success" type="submit">
                            <FontAwesomeIcon icon={faSave} /> Submit
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        );
    }
}